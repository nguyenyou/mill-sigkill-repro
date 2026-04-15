package generated

final case class Data1004(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1004 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1004 = copy(value = value * k)
  def addTag(t: String): Data1004 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1004 = copy(meta = meta.updated(k, v))
  def merge(other: Data1004): Data1004 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1004 {
  given Ordering[Data1004] = Ordering.by(_.id)
  def empty: Data1004 = Data1004(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1004 =
    Data1004(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1004] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
