package generated

final case class Data100(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data100 = copy(name = name.toUpperCase)
  def scale(k: Double): Data100 = copy(value = value * k)
  def addTag(t: String): Data100 = copy(tags = t :: tags)
  def put(k: String, v: String): Data100 = copy(meta = meta.updated(k, v))
  def merge(other: Data100): Data100 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data100 {
  given Ordering[Data100] = Ordering.by(_.id)
  def empty: Data100 = Data100(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data100 =
    Data100(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data100] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
