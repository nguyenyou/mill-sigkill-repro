package generated

final case class Data968(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data968 = copy(name = name.toUpperCase)
  def scale(k: Double): Data968 = copy(value = value * k)
  def addTag(t: String): Data968 = copy(tags = t :: tags)
  def put(k: String, v: String): Data968 = copy(meta = meta.updated(k, v))
  def merge(other: Data968): Data968 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data968 {
  given Ordering[Data968] = Ordering.by(_.id)
  def empty: Data968 = Data968(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data968 =
    Data968(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data968] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
