package generated

final case class Data1172(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1172 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1172 = copy(value = value * k)
  def addTag(t: String): Data1172 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1172 = copy(meta = meta.updated(k, v))
  def merge(other: Data1172): Data1172 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1172 {
  given Ordering[Data1172] = Ordering.by(_.id)
  def empty: Data1172 = Data1172(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1172 =
    Data1172(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1172] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
