package generated

final case class Data1422(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1422 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1422 = copy(value = value * k)
  def addTag(t: String): Data1422 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1422 = copy(meta = meta.updated(k, v))
  def merge(other: Data1422): Data1422 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1422 {
  given Ordering[Data1422] = Ordering.by(_.id)
  def empty: Data1422 = Data1422(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1422 =
    Data1422(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1422] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
