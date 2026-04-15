package generated

final case class Data629(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data629 = copy(name = name.toUpperCase)
  def scale(k: Double): Data629 = copy(value = value * k)
  def addTag(t: String): Data629 = copy(tags = t :: tags)
  def put(k: String, v: String): Data629 = copy(meta = meta.updated(k, v))
  def merge(other: Data629): Data629 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data629 {
  given Ordering[Data629] = Ordering.by(_.id)
  def empty: Data629 = Data629(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data629 =
    Data629(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data629] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
