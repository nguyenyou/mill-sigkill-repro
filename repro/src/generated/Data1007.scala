package generated

final case class Data1007(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1007 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1007 = copy(value = value * k)
  def addTag(t: String): Data1007 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1007 = copy(meta = meta.updated(k, v))
  def merge(other: Data1007): Data1007 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1007 {
  given Ordering[Data1007] = Ordering.by(_.id)
  def empty: Data1007 = Data1007(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1007 =
    Data1007(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1007] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
