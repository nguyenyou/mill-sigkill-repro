package generated

final case class Data1284(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1284 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1284 = copy(value = value * k)
  def addTag(t: String): Data1284 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1284 = copy(meta = meta.updated(k, v))
  def merge(other: Data1284): Data1284 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1284 {
  given Ordering[Data1284] = Ordering.by(_.id)
  def empty: Data1284 = Data1284(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1284 =
    Data1284(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1284] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
