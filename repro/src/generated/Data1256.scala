package generated

final case class Data1256(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1256 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1256 = copy(value = value * k)
  def addTag(t: String): Data1256 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1256 = copy(meta = meta.updated(k, v))
  def merge(other: Data1256): Data1256 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1256 {
  given Ordering[Data1256] = Ordering.by(_.id)
  def empty: Data1256 = Data1256(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1256 =
    Data1256(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1256] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
