package generated

final case class Data1411(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1411 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1411 = copy(value = value * k)
  def addTag(t: String): Data1411 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1411 = copy(meta = meta.updated(k, v))
  def merge(other: Data1411): Data1411 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1411 {
  given Ordering[Data1411] = Ordering.by(_.id)
  def empty: Data1411 = Data1411(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1411 =
    Data1411(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1411] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
