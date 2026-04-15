package generated

final case class Data1492(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1492 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1492 = copy(value = value * k)
  def addTag(t: String): Data1492 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1492 = copy(meta = meta.updated(k, v))
  def merge(other: Data1492): Data1492 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1492 {
  given Ordering[Data1492] = Ordering.by(_.id)
  def empty: Data1492 = Data1492(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1492 =
    Data1492(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1492] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
