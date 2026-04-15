package generated

final case class Data1372(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1372 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1372 = copy(value = value * k)
  def addTag(t: String): Data1372 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1372 = copy(meta = meta.updated(k, v))
  def merge(other: Data1372): Data1372 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1372 {
  given Ordering[Data1372] = Ordering.by(_.id)
  def empty: Data1372 = Data1372(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1372 =
    Data1372(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1372] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
