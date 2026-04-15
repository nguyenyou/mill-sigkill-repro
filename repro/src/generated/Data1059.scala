package generated

final case class Data1059(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1059 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1059 = copy(value = value * k)
  def addTag(t: String): Data1059 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1059 = copy(meta = meta.updated(k, v))
  def merge(other: Data1059): Data1059 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1059 {
  given Ordering[Data1059] = Ordering.by(_.id)
  def empty: Data1059 = Data1059(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1059 =
    Data1059(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1059] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
