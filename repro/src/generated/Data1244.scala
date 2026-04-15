package generated

final case class Data1244(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1244 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1244 = copy(value = value * k)
  def addTag(t: String): Data1244 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1244 = copy(meta = meta.updated(k, v))
  def merge(other: Data1244): Data1244 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1244 {
  given Ordering[Data1244] = Ordering.by(_.id)
  def empty: Data1244 = Data1244(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1244 =
    Data1244(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1244] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
