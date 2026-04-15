package generated

final case class Data35(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data35 = copy(name = name.toUpperCase)
  def scale(k: Double): Data35 = copy(value = value * k)
  def addTag(t: String): Data35 = copy(tags = t :: tags)
  def put(k: String, v: String): Data35 = copy(meta = meta.updated(k, v))
  def merge(other: Data35): Data35 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data35 {
  given Ordering[Data35] = Ordering.by(_.id)
  def empty: Data35 = Data35(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data35 =
    Data35(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data35] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
