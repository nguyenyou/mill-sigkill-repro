package generated

final case class Data1160(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1160 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1160 = copy(value = value * k)
  def addTag(t: String): Data1160 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1160 = copy(meta = meta.updated(k, v))
  def merge(other: Data1160): Data1160 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1160 {
  given Ordering[Data1160] = Ordering.by(_.id)
  def empty: Data1160 = Data1160(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1160 =
    Data1160(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1160] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
