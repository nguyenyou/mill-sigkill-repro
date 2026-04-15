package generated

final case class Data137(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data137 = copy(name = name.toUpperCase)
  def scale(k: Double): Data137 = copy(value = value * k)
  def addTag(t: String): Data137 = copy(tags = t :: tags)
  def put(k: String, v: String): Data137 = copy(meta = meta.updated(k, v))
  def merge(other: Data137): Data137 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data137 {
  given Ordering[Data137] = Ordering.by(_.id)
  def empty: Data137 = Data137(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data137 =
    Data137(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data137] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
