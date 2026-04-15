package generated

final case class Data1289(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1289 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1289 = copy(value = value * k)
  def addTag(t: String): Data1289 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1289 = copy(meta = meta.updated(k, v))
  def merge(other: Data1289): Data1289 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1289 {
  given Ordering[Data1289] = Ordering.by(_.id)
  def empty: Data1289 = Data1289(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1289 =
    Data1289(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1289] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
