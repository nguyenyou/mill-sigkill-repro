package generated

final case class Data1313(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1313 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1313 = copy(value = value * k)
  def addTag(t: String): Data1313 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1313 = copy(meta = meta.updated(k, v))
  def merge(other: Data1313): Data1313 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1313 {
  given Ordering[Data1313] = Ordering.by(_.id)
  def empty: Data1313 = Data1313(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1313 =
    Data1313(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1313] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
