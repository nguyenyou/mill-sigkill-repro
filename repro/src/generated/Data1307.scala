package generated

final case class Data1307(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1307 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1307 = copy(value = value * k)
  def addTag(t: String): Data1307 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1307 = copy(meta = meta.updated(k, v))
  def merge(other: Data1307): Data1307 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1307 {
  given Ordering[Data1307] = Ordering.by(_.id)
  def empty: Data1307 = Data1307(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1307 =
    Data1307(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1307] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
