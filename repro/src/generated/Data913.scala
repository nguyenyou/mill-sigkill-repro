package generated

final case class Data913(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data913 = copy(name = name.toUpperCase)
  def scale(k: Double): Data913 = copy(value = value * k)
  def addTag(t: String): Data913 = copy(tags = t :: tags)
  def put(k: String, v: String): Data913 = copy(meta = meta.updated(k, v))
  def merge(other: Data913): Data913 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data913 {
  given Ordering[Data913] = Ordering.by(_.id)
  def empty: Data913 = Data913(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data913 =
    Data913(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data913] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
